import { User } from "./user.dto";

export interface ResumeUploadResponseDTO{
  id: number;
  filename: string;
  extractedText: string;
  analysis: string;
  suggestedJobRoles: string[];
  user: User;
  createdAt: Date;
  status:  string;
  message: string;
}