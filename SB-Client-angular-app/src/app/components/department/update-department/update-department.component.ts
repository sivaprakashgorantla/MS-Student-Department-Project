import { Component } from '@angular/core';
import { DepartmentService } from '../../../department.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormGroup, FormControl, Validators, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Department } from '../../../department';

@Component({
  selector: 'app-update-department',
  standalone: true,
  imports: [UpdateDepartmentComponent, FormsModule, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './update-department.component.html',
  styleUrl: './update-department.component.css'
})
export class UpdateDepartmentComponent {

  department: any;


  constructor(private departmentService: DepartmentService, private activatedroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.activatedroute.snapshot.params['id'];
    console.log(id);

    this.department = this.departmentService.getDepartment(id)
     .subscribe({
       next: (response: Department | undefined) => {
         if (response != undefined) {
           console.log(response);
           this.department = response;
           this.departmentSaveform.controls['departmentName'].setValue(response.departmentName);
           this.departmentSaveform.controls['departmentAddress'].setValue(response.departmentAddress);
           this.departmentSaveform.controls['departmentCode'].setValue(response.departmentCode);
         }
       },
       error: (error: any) => {

       }

     });
  }

  departmentSaveform = new FormGroup({
    departmentName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    departmentAddress: new FormControl('', [Validators.required, Validators.minLength(5)]),
    departmentCode: new FormControl('', [Validators.required, Validators.email]),
    student_branch: new FormControl()
  });

  updateDepartment(): void {
    let id = this.activatedroute.snapshot.params['id']
    console.log(this.departmentSaveform);

    this.departmentService.updateDepartment(id, {
      departmentId: 122201,
      departmentName: this.departmentSaveform.value.departmentName!,
      departmentAddress: this.departmentSaveform.value.departmentAddress!,
      departmentCode: this.departmentSaveform.value.departmentCode!,
    }).subscribe(
      {
        next: (response: any) => {
          this.router.navigateByUrl('/department-list');
        },
        error: (error: any) => {
          console.log(error);
        }
      }
    )
    this.resetForm();
  }

  resetForm(): void {
    this.department = { departmentId: 0, departmentName: '', departmentAddress: '', departmentCode: '' };

  }

}
