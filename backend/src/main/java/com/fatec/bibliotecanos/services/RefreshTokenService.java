package com.fatec.bibliotecanos.services;

import com.fatec.bibliotecanos.entities.RefreshToken;
import com.fatec.bibliotecanos.repositories.RefreshTokenRepository;
import com.fatec.bibliotecanos.repositories.UsuarioRepository;
import com.fatec.bibliotecanos.resources.exceptions.TokenRefreshException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RefreshTokenService {
    @Value("${bibliotecanos.app.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(Long usuarioId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUsuario(usuarioRepository.findById(usuarioId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(Long usuarioId) {
        return refreshTokenRepository.deleteByUsuario(usuarioRepository.findById(usuarioId).get());
    }

}
