import { Component } from '@angular/core';
import { ResumeUploadResponseDTO } from '../../models/resume-upload-response.dto';
import { ResumeService } from '../../service/resume.service';
import { CommonModule } from '@angular/common';
// Correct Material imports
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatDividerModule } from '@angular/material/divider';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
@Component({
  standalone: true,
  selector: 'app-resume-analyzer',
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    MatIconModule,
    MatListModule,
    MatExpansionModule,
    MatDividerModule,
    MatProgressSpinnerModule,
  ],
  templateUrl: './resume-analyzer.component.html',
  styleUrl: './resume-analyzer.component.css',
})
export class ResumeAnalyzerComponent {
  selectedFile: File | null = null;
  uploadResponse: ResumeUploadResponseDTO | null = null;
  errorMessage: string | null = null;
  isLoading = false;

  constructor(private resumeService: ResumeService) {}
  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0] as File;
    this.errorMessage = null;
    this.uploadResponse = null;
  }

  uploadResume(): void {
    if (!this.selectedFile) {
      this.errorMessage = 'Please select a file';
      return;
    }

    if (!this.isValidFileType(this.selectedFile)) {
      this.errorMessage =
        'Invalid file type. Please upload a PDF or DOCX file.';
      return;
    }

    this.isLoading = true;
    this.resumeService.analyzeResume(this.selectedFile).subscribe({
      next: (response) => {
        this.uploadResponse = response;
        this.isLoading = false;
      },
      error: (err) => {
        this.errorMessage =
          err.error?.message || 'An error occurred during upload';
        this.isLoading = false;
      },
    });
  }

  clearFile(){
    
  }
  private isValidFileType(file: File): boolean {
    const allowedTypes = [
      'application/pdf',
      'application/vnd.openxmlformats-officedocument.wordprocessingml.document',
    ];
    return allowedTypes.includes(file.type);
  }
}
