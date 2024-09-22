import { Component } from '@angular/core';
import { ClassService } from '../../../class.service';
import { FormGroup, FormControl, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Department } from '../../../department';
import { Class } from '../../../models/class/class';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-class',
  standalone: true,
  imports: [UpdateClassComponent, FormsModule, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './update-class.component.html',
  styleUrl: './update-class.component.css'
})
export class UpdateClassComponent {

  class: any;


  constructor(private classService: ClassService, private activatedroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.activatedroute.snapshot.params['id'];
    console.log(id);

    this.class = this.classService.getClass(id)
     .subscribe({
       next: (response: Class | undefined) => {
         if (response != undefined) {
           console.log(response);
           this.class = response;
           this.classSaveform.controls['className'].setValue(response.className);
           this.classSaveform.controls['classCode'].setValue(response.classCode);
         }
       },
       error: (error: any) => {

       }

     });
  }

  classSaveform = new FormGroup({
    className: new FormControl('', [Validators.required, Validators.minLength(5)]),
    classCode: new FormControl('', [Validators.required, Validators.minLength(5)]),
    student_branch: new FormControl()
  });

  updateClass(): void {
    let id = this.activatedroute.snapshot.params['id']
    console.log(this.classSaveform);

    this.classService.updateClass(id, {
      classId: 122201,
      className: this.classSaveform.value.className!,
      classCode: this.classSaveform.value.classCode!,
    }).subscribe(
      {
        next: (response: any) => {
          this.router.navigateByUrl('/class-list');
        },
        error: (error: any) => {
          console.log(error);
        }
      }
    )
    this.resetForm();
  }

  resetForm(): void {
    this.class= { classId: 0, className: '',  classCode: '' };

  }


}
