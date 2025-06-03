import { Routes } from '@angular/router';
import { ResumeAnalyzerComponent } from './components/resume-analyzer/resume-analyzer.component';
import { AboutComponent } from './pages/about.component';
import { ContactComponent } from './pages/contact.component';
import { LoginComponent } from './pages/login.component';
import { SignupComponent } from './pages/signup.component';
export const routes: Routes = [
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'contact',
    component: ContactComponent,
  },
  {
    path: 'about',
    component: AboutComponent,
  },
  {
    path: 'resume',
    component: ResumeAnalyzerComponent,
  },
  {
    path: '',
    redirectTo: 'resume',
    pathMatch: 'full',
  },
];
