import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

 // private baseUrl='http://localhost:7777/api'; //apiServerUrl
  private employeeUrl=environment.apiBaseUrl+'/employee';
 

  constructor(private httpClient:HttpClient) { }


  public getEmployees():Observable<Employee[]>{ 
    return this.httpClient.get<Employee[]>(`${this.employeeUrl}/all`);
  }

  public addEmployee(employee:Employee):Observable<Employee>{
    return this.httpClient.post<Employee>(`${this.employeeUrl}/add`,employee);
  }

  public updateEmployee(employee:Employee):Observable<Employee>{
    return this.httpClient.put<Employee>(`${this.employeeUrl}/update`,employee);
  }

  public deleteEmployee(employeeId: number):Observable<void>{
    return this.httpClient.delete<void>(`${this.employeeUrl}/delete/${employeeId}`);
  }




}
