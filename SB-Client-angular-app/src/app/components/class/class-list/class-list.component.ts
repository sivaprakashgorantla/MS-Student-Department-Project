import { Component } from '@angular/core';
import { Class } from '../../../models/class/class';
import { ClassService } from '../../../class.service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterModule } from '@angular/router';

@Component({
  selector: 'app-class-list',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterModule],
  templateUrl: './class-list.component.html',
  styleUrl: './class-list.component.css'
})
export class ClassListComponent {
  classess: Class [] = [];

  constructor(private classService: ClassService) { }

  ngOnInit(): void {
    this.loadTable();
  }

  loadTable() {
    this.classService.getClassList().subscribe({
      next: (response: Class[]) => {
        console.log(response);
        this.classess = response;
      },
      error: (error: HttpErrorResponse) => {  // Explicitly define the error type
        console.error('Error loading Class:', error.message);
      }
    });
  }

  deleteClass(id: number): void {
    console.log('delete Class : ' + id);

    this.classService.deleteClass(id).subscribe({
      next: () => {
        this.loadTable();  // Refresh the table after deleting the department
      },
      error: (error: HttpErrorResponse) => {  // Explicitly define the error type
        console.error('Error deleting Classes:', error.message);
      }
    });
  }

}
