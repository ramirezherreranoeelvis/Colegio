export interface Curso {
        codigo: string;
        nombre: string;
        numeroSalon: number;
        piso: number;
        horaInicio: string;
        horaFin: string;
        dia: string;
        profesores: string[];
        portada: string;
        numeroSesiones: number;
        contenidos: Contenido[];
}
class Contenido {
        nombre: string;
        numero: number;
        tipo: string;
        recursos: Recurso[];
}
class Recurso {
        nombre: string;
        descripcion: string;
        tipo: string;
        items: Item[];
}
class Item {
        dniPerson: string;
        tipo: string;
        contenido: string;
}