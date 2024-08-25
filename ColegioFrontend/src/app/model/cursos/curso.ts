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
        contenidos: ContenidoCurso[];
}

export class ContenidoCurso {
        nombre: string;
        numero: number;
        tipo: string;
        recursos: RecursoContenidoCurso[];
}

export class RecursoContenidoCurso {
        nombre: string;
        descripcion: string;
        tipo: string;
        items: ItemRecursoCurso[];
        notas: NotaRecursoCurso[];
}

export class ItemRecursoCurso {
        dniPerson: string;
        tipo: string;
        contenido: string;
        nombreArchivo: string;
}

export class NotaRecursoCurso {
        comentario: string;
        nota: number;
        fechaCalificacion: string;
}