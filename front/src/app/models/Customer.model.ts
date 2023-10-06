import { Role } from "./role";
export interface Customer{
    id: number;
    email: string;
    dni: string;
    name: string;
    surname: string;
    surname2: string;
    street: string;
    gate: number;
    number: number;
    stairs: string;
    floor: number;
    letter: string;
    postalcode: number;
    town: string;
    province: string;
    password: string;
    confirmPassword: string; 
    role:Role;
}