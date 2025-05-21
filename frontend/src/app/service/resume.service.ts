import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ResumeUploadResponseDTO } from '../models/resume-upload-response.dto';

@Injectable({
  providedIn: 'root'
})
export class ResumeService{
  private apiUrl = 'http://localhost:8081/api/resumes';
  
  constructor(private http: HttpClient) { }

  analyzeResume(file: File): Observable<ResumeUploadResponseDTO>{
    const formData = new FormData();
    formData.append('file', file);
    return this.http.post<ResumeUploadResponseDTO>(`${this.apiUrl}/analyze`, formData);
  }
}
