# GateKey
## Reconhecimento de Moradores Condomínio/Empresa

O GateKey tem como objetivos principais: 

    Automatizar o controle de entrada e saída de pessoas em ambientes privados.
     
    Aumentar a segurança por meio de reconhecimento facial e registro de acessos. 

    Disponibilizar relatórios e históricos para auditoria e gestão de segurança. 

Modelo de Negócio:

    On-premises

## Modelagem do Banco de Dados (Der)

## Requisitos:

    - Requisitos Funcionais (RF) 
• RF01: O sistema deve permitir o cadastro de moradores, funcionários e visitantes, incluindo 
nome, documento, unidade/empresa e foto. 

• RF02: O sistema deve realizar reconhecimento no momento da entrada. 

• RF03: O sistema deve liberar automaticamente o acesso quando o morador/funcionário for 
identificado. 

• RF04: O sistema deve registrar data, hora e identidade em cada acesso. 

• RF05: O sistema deve permitir consulta ao histórico de acessos por administradores.  

• RF06: O sistema deve oferecer backup e restauração de dados. 

• RF07: O sistema deve enviar notificações em tempo real em caso de tentativa de acesso não 
autorizado. 

• RF08: O sistema deve possibilitar integração com dispositivos físicos (portões, catracas, 
cancelas).  

• RF09: O sistema deve manter registro de tentativas de acesso negadas, incluindo motivo. 

• RF10: O sistema deve oferecer perfis de acesso diferenciados (administrador, segurança, 
morador). 

• RF11: O sistema deve permitir auditoria completa de operações administrativas (cadastros, 
alterações, exclusões). 

• RF12: O sistema deve permitir configuração de níveis de permissão para usuários internos (ex.: 
segurança pode consultar mas não alterar dados).

    - Requisitos Não Funcionais (RNF) 

• RNF01: O reconhecimento digital deve ocorrer em menos de 3 segundos. 

• RNF02: O sistema deve ter taxa de acerto ≥ 95% no reconhecimento digital.

• RNF03: O sistema deve estar disponível 24 horas por dia, 7 dias por semana. 

• RNF04: A interface deve ser intuitiva e responsiva, compatível com desktop e mobile. 

• RNF05: O sistema deve suportar expansão de até 10.000 usuários sem perda de desempenho. 

• RNF06: O sistema deve estar em conformidade com a LGPD. 

• RNF07: O sistema deve permitir auditoria e rastreabilidade de acessos e alterações. 

• RNF08: O tempo de resposta para consultas de histórico não deve exceder 5 segundos. 

• RNF09: O sistema deve realizar backups automáticos diários. 

• RNF10: O sistema deve manter registros de logs por no mínimo 12 meses.


## Escopo da entrega

<img width="800" height="1080" alt="Captura de tela 2025-03-04 182738" src="https://raw.githubusercontent.com/davidfreitass/GateKey/refs/heads/main/images/EscopoDeEntrega.PNG" />

