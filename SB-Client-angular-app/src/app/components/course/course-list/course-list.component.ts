import { Component } from '@angular/core';
import { Course } from '../../../models/course';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterModule } from '@angular/router';
import { CourseService } from '../../../course.service';

@Component({
  selector: 'app-class-list',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterModule],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent {
  courses: Course [] = [];

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.loadTable();
  }

  loadTable() {
    this.courseService.getCourseList().subscribe({
      next: (response: Course[]) => {
        console.log(response);
        this.courses = response;
      },
      error: (error: HttpErrorResponse) => {  // Explicitly define the error type
        console.error('Error loading Course:', error.message);
      }
    });
  }

  deleteCourse(id: number): void {
    console.log('delete Class : ' + id);

    this.courseService.deleteCourse(id).subscribe({
      next: () => {
        this.loadTable();  // Refresh the table after deleting the department
      },
      error: (error: HttpErrorResponse) => {  // Explicitly define the error type
        console.error('Error deleting Course:', error.message);
      }
    });
  }

}
