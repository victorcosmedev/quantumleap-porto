export type TipoVeiculo = {
    idVeiculo: number; 
    montadoraVeiculo: string; 
    modeloVeiculo: string; 
    anoVeiculo: number; 
    quantidadeQuilometros: number; 
    placaVeiculo: string; 
    nomeCliente: string | null; 
    idCliente: number | null; 
};


export type TipoCliente = {
    idCliente: number;
    nomeCliente: string;
    emailCliente: string;
    telefoneCliente: string;
    senhaCliente: string;
    clientePorto: boolean;
    localizacaoCliente: string;
}

export type Problema = {
    problema: string;
}