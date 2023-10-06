import { Injectable } from '@angular/core';
import { Customer } from '../models/Customer.model';
import { Role } from '../models/role';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private customerUrl = 'http://localhost:8000/customers'
  private roleUrl = 'http://localhost:8000/roles'
  constructor(private httpClient: HttpClient) { }
  register(customer : Customer){
    return this.httpClient.post<Customer>(this.customerUrl, customer);
  }
  getCustomer(email: string) : Observable<Customer>{
    return this.httpClient.get<Customer>(this.customerUrl + "/" + email);
  }

  getCustomers() : any{
    return this.httpClient.get<any>(this.customerUrl);
  }
}
