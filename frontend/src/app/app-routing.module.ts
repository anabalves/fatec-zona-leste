import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SigninComponent } from './components/signin/signin.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { LandingComponent } from './components/landing/landing.component';
import { ConsultarLivroComponent } from './components/consultar-livro/consultar-livro.component';
import { ReservarComponent } from './components/reservar/reservar.component';
import { SucessoComponent } from './components/sucesso/sucesso.component';
import { RegisterLivroComponent } from './components/register-livro/register-livro.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'landing' },
  { path: 'signin', component: SigninComponent },
  { path: 'registerLivro', component: RegisterLivroComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'landing', component: LandingComponent },
  { path: 'consultar/:id', component: ConsultarLivroComponent },
  { path: 'reservar/:id', component: ReservarComponent },
  { path: 'sucesso', component: SucessoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }