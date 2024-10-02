import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Department } from '../../../models/department';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../../course.service';
import { Course } from '../../../models/course';

@Component({
  selector: 'app-update-class',
  standalone: true, 
  imports: [UpdateCourseComponent, FormsModule, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './update-course.component.html',
  styleUrl: './update-course.component.css'
})
export class UpdateCourseComponent {

  course: any;


  constructor(private courseService: CourseService, private activatedroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.activatedroute.snapshot.params['id'];
    console.log(id);

    this.course = this.courseService.getCourse(id)
     .subscribe({
       next: (response: Course | undefined) => {
         if (response != undefined) {
           console.log(response);
           this.course = response;
           this.courseSaveform.controls['courseName'].setValue(response.courseName);
           this.courseSaveform.controls['duration'].setValue(response.duration.toString());
           this.courseSaveform.controls['courseCode'].setValue(response.courseCode);
         }
       },
       error: (error: any) => {

       }

     });
  }

  courseSaveform = new FormGroup({
    courseName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    duration: new FormControl('', [Validators.required, Validators.minLength(1)]),
    courseCode: new FormControl('', [Validators.required, Validators.minLength(5)]),
    student_branch: new FormControl()
  });

  updateCourse(): void {
    let id = this.activatedroute.snapshot.params['id']
    console.log(this.courseSaveform);

    this.courseService.updateCourse(id, {
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
    this.course= { courseId: 0, courseName: '', courseCode: '' ,  duration: 0};

  }


}
