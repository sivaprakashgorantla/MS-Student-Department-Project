import { Component } from '@angular/core';
import { Course } from '../../../models/course';
import { CourseService } from '../../../course.service';
import { FormGroup, FormControl, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-course',
  standalone: true,
  imports: [AddCourseComponent, FormsModule, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './add-course.component.html',
  styleUrl: './add-course.component.css'
})
export class AddCourseComponent {

  course: Course = {
    courseId: 0,
    courseName:'',
    courseCode: '',
    duration: 0,
  };

  submitted = false;

  ngOnInit() {
    this.submitted = false;
  }

  constructor(private coruseService: CourseService, private router: Router) { }


  saveCourse(): void {
    console.log(this.courseSaveform);

    this.coruseService.createCourse({
      courseId: 122201,
      courseName: this.courseSaveform.value.courseName!,
      duration: Number(this.courseSaveform.value.duration!),
      courseCode: this.courseSaveform.value.courseCode!,
    }).subscribe(
      {
        next: (response: any) => {
          this.router.navigateByUrl('/course-list');
        },
        error: (error: any) => {
          console.log(error);
        }
      }


    )

    this.resetForm();
  }

  resetForm(): void {
    this.course = { courseId: 0, courseName: '', duration: 0, courseCode: '' };
  }

  addDepartmentForm() {
    this.submitted = false;
    this.courseSaveform.reset();

  }

  courseSaveform = new FormGroup({
    courseName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    duration: new FormControl('', [Validators.required, Validators.minLength(5)]),
    courseCode: new FormControl('', [Validators.required, Validators.minLength(5)]),
    student_branch: new FormControl()
  });


}
