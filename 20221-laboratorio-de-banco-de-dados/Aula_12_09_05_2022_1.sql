/* 
CRIAR PROCEDURE QUE:

Liste os códigos dos professores com título denominado 'Doutor' que não ministraram aulas em 2019/1.
Caso nao existam professores dar uma mensagem de erro usando um dos métodos para o tratamento de Exceções.
*/

USE AULA_12_09_05_2022;

DROP PROCEDURE IF EXISTS PROC_LIST_PROF_DOUTOR;

DELIMITER $$
CREATE PROCEDURE PROC_LIST_PROF_DOUTOR(IN SEMESTRE_PARAM INT)
BEGIN
    DECLARE P_COD_PROF INT;
	DECLARE DONE INT DEFAULT 0;
    DECLARE C1 CURSOR FOR
		SELECT 
			A.COD_PROF
		FROM 
			TB_PROFESSOR A, 
            TB_TITULACAO B, 
            TB_PROF_TURMA C
        WHERE 
			A.COD_DEPTO = C.COD_DEPTO
        AND
			A.COD_TIT = B.COD_TIT 
		AND 
			B.NOME_TIT = 'Doutor' 
		AND 
			C.ANO_SEM != SEMESTRE_PARAM;

        DECLARE CONTINUE HANDLER FOR NOT FOUND SET DONE = 1;
        
		OPEN C1;
			FETCH C1 INTO P_COD_PROF;
			IF DONE = 1 THEN
				SELECT 'ERROR - REGISTRO NAO ENCONTRADO' MENSAGEM;
			ELSE
				SELECT P_COD_PROF;
				WHILE DONE != 1 DO
					FETCH C1 INTO P_COD_PROF;
					SELECT P_COD_PROF;
				END WHILE;
			END IF;
        CLOSE C1;
END $$
DELIMITER ;

CALL PROC_LIST_PROF_DOUTOR(20191);