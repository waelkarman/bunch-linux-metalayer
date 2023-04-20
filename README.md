# Bunch Linux purpose
Bunch linux is a project created for educational purposes. The goal is to learn how to build your own custom version of linux for Embedded Systems as well as the well-known goal of every developer, have fun!
The project also acts as an entry point for those who want to approach the embedded world for business reasons or even just to fully understand the foundations of systems and applications starting from the lowest possible level.
The intent therefore is not so much the production of applications that work on an Embedded System as the possibility of porting any application to an embedded one.

# How to build
bunch-linux derives directly from poky by extending and customizing the known distro already included in the Yocto project if necessary.
    

# Custom
### wayland
Wayland è il più recente protocollo per la gestione grafica, è possibile customizzare il proprio ambiente virtuale partendo dal noto compositor weston.  
### directfb
Oltre all'utilizzo di weston è possibile graficare lapropria applicazione senza la presenza di un ambiente virtuale passando sul frame buffer direttamente i dati ricevuti dall applicazione di interesse.
### alsa
Alsa è la principale architettura audio per il sistema operativo linux. La sua customizzazione propone la creazione di profili per gestire i diversi canali audio ed il loro comportamento. 

# Integration
Come precedentemente discusso il progetto mira, oltre alla customizzazione della distro stessa anche la semplificazione dell integrazione di applicativi di ogni genere.
Fin ora gli applicativi correttamente integrati compongono:
1. applicativi in C
2. applicativi in C++
3. applicativi in QT
4. applicativi in QML
5. moduli del kernel

# Develop your application

