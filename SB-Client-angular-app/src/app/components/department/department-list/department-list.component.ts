import { Component } from '@angular/core';
import { Department } from '../../../models/department';
import { DepartmentService } from '../../../department.service';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterModule } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http'; // Import HttpErrorResponse

@Component({
  selector: 'app-department-list',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterModule],
  templateUrl: './department-list.component.html',
  styleUrl: './department-list.component.css'
})
export class DepartmentListComponent {
  departments: Department[] = [];

  constructor(private departmentService: DepartmentService) { }

  ngOnInit(): void {
    this.loadTable();
  }

  loadTable() {
    this.departmentService.getDepartmentList().subscribe({
      next: (response: Department[]) => {
        console.log(response);
        this.departments = response;
      },
      error: (error: HttpErrorResponse) => {  // Explicitly define the error type
        console.error('Error loading departments:', error.message);
      }
    });
  }

  deleteDepartment(id: number): void {
    console.log('delete student : ' + id);

    this.departmentService.deleteDepartment(id).subscribe({
      next: () => {
        this.loadTable();  // Refresh the table after deleting the department
      },
      error: (error: HttpErrorResponse) => {  // Explicitly define the error type
        console.error('Error deleting department:', error.message);
      }
    });
  }
}
