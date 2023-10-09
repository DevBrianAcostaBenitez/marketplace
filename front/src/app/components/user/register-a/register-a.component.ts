import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Customer } from 'src/app/models/Customer.model';
import { Router } from '@angular/router';
import { CustomerService } from 'src/app/services/customer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register-a',
  templateUrl: './register-a.component.html',
  styleUrls: ['./register-a.component.scss'],
})
export class RegisterAComponent {
  selectedDniType: string = 'DNI';
  registrationForm!: FormGroup;
  newCustomer : Customer = {
    id: 0,
    email: '',
    name: '',
    surname: '',
    dni: '',
    surname2: '',
    street: '',
    number: 0,
    stairs: '',
    gate: 0,
    floor: 0,
    letter: '',
    postalcode: 0,
    town: '',
    province: '',
    password: '',
    confirmPassword: '',
    roleId: 1
  }
  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private customerService: CustomerService
  ) {
    this.registrationForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/)]],
      dni: ['', [Validators.required, Validators.pattern('[0-9]{8}[A-Z]')]],
      name: ['', [Validators.required, Validators.pattern('[A-Za-z ]*')]], 
      surname:  ['', [Validators.required, Validators.pattern('[A-Za-z ]*')]], 
      surname2: [''],
      street: ['', [Validators.required]],
      number: [''],
      gate: [''],
      stairs: [''],
      floor: [''],
      letter: [''],
      postalcode: [''],
      town: [''],
      province: [''],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required]],
      roleId:1
    },  { validators: this.passwordMatchValidator.bind(this) });
  }
  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    if (password !== confirmPassword) {
      formGroup.get('confirmPassword')?.setErrors({ passwordMismatch: true });
    } else {
      formGroup.get('confirmPassword')?.setErrors(null);
    }
  }
  registerCustomer(): void {
    console.log(this.registrationForm.valid)
    if (this.registrationForm.valid) {
      const registrationData: Customer = {
        ...this.registrationForm.value,
        roleId: 1
      };
      console.log(registrationData)
      this.customerService.register(registrationData).subscribe(
        (response: any) => {
          console.log(response)
          Swal.fire({
            icon: 'success',
            title: 'Bienvenid@',
            text: 'Registro realizado con éxito!'
          }).then(() => {
            this.router.navigate(['/comicList']);
          });
        },
        (error: any) => {
          Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Error durante el registro'
          });
          console.error('Error durante el registro', error);
        }
      );
    } else {
      Swal.fire({
        icon: 'error',
        title: 'Error de validación',
        text: 'Por favor, complete todos los campos correctamente'
      });
    }
  }
}  
