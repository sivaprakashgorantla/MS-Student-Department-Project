import { Injectable } from '@angular/core';
import { Class } from './models/class/class';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClassService {

  private baseUrl = 'http://localhost:9988/api/class';  
  
  
  constructor(private http: HttpClient) { }
  
  getClassList(): Observable<any> {
  
    return this.http.get(`${this.baseUrl}`);
  }

  getClass(id:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createClass(department: Class):Observable<any> {
   return this.http.post(`${this.baseUrl}`, department);
  }

  
  updateClass(id: number, department: Class): Observable<Object>{
    // return this.http.put(`${this.baseUrl}edit/${id}`, student);
    return this.http.put(`${this.baseUrl}/${id}`, department);
  }

  deleteClass(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }}
