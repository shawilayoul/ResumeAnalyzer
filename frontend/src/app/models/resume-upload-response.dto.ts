import { User } from './user.dto';

export interface ResumeUploadResponseDTO {
  id: number;
  filename: string;
  feedback: string;
  user: User;
  createdAt: Date;
  status: string;
  message: string;
}
