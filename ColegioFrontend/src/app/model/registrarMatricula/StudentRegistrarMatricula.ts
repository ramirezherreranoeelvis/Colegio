import { Enrollment } from "./nextEnrollment";

export interface StudentRegistrarMatricula {
        dni: string;
        name: string;
        surnamePaternal: string;
        surnameMaternal: string;
        phoneNumber: string;
        accessEnabled: boolean;
        username: string;
        password: string;
        description: string;
        grade: string;
        nextEnrollment: Enrollment;
}