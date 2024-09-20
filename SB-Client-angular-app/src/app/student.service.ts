import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:9988/api/student';

  
  constructor(private http: HttpClient) { }

  getStudentList(): Observable<any> {
    // return this.http.get(`${this.baseUrl}` + 'allStudents');
    return this.http.get(`${this.baseUrl}`);
  }

  createStudent(student: object): Observable<object> {
    // return this.http.post(`${this.baseUrl}` + 'save', student);
    return this.http.post(`${this.baseUrl}`, student);

  }



  getStudent(id: number): Observable<any> {
    // return this.http.get(`${this.baseUrl}getStudent/${id}`);
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  updateStudent(id: number, student: Student): Observable<Object>{
    // return this.http.put(`${this.baseUrl}edit/${id}`, student);
    return this.http.put(`${this.baseUrl}/${id}`, student);
  }

  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

}
