import { Routes } from '@angular/router';
import { ResumeAnalyzerComponent } from './components/resume-analyzer/resume-analyzer.component';

export const routes: Routes = [
    {
        path:'resume',
        component: ResumeAnalyzerComponent
    },{
        path:'',  redirectTo: 'resume', pathMatch: 'full'
    }
];
