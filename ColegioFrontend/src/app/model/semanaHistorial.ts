export class SemanaHistorial {
        name: string
        dias: Dia[]
}
class Dia {
        name: string
        entrada: Evento
        salida: Evento
        elementoFinal: boolean
}
class Evento {
        content: string
        status: string
}