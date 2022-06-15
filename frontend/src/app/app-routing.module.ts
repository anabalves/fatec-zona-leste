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
import { ListaAluguelComponent } from './components/lista-aluguel/lista-aluguel.component';
import { HomeAdminComponent } from './components/home-admin/home-admin.component';
import { LivroComponent } from './components/livro/livro.component'
import { CategoriaComponent } from './components/categoria/categoria.component'
import { EditoraComponent } from './components/editora/editora.component'
import { LivroeditComponent } from './components/livro/edit/livroedit/livroedit.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'landing' },
  { path: 'signin', component: SigninComponent },
  { path: 'registerLivro', component: RegisterLivroComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'landing', component: LandingComponent },
  { path: 'consultar/:id', component: ConsultarLivroComponent },
  { path: 'reservar/:id', component: ReservarComponent },
  { path: 'sucesso', component: SucessoComponent },
  { path: 'lista-aluguel', component: ListaAluguelComponent },
  { path: 'home-admin', component: HomeAdminComponent },
  { path: 'livro', component: LivroComponent },
  { path: 'livro/editar/:id', component: LivroeditComponent },
  { path: 'categoria', component: CategoriaComponent },
  { path: 'editora', component: EditoraComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }