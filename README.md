# Bunch Linux purpose
Bunch linux is a project created for educational purposes. The goal is to learn how to build your own custom version of linux for Embedded Systems as well as the well-known goal of every developer, have fun!
The project also acts as an entry point for those who want to approach the embedded world for business reasons or even just to fully understand the foundations of systems and applications starting from the lowest possible level.
The intent therefore is not so much the production of applications that work on an Embedded System as the possibility of porting any application to an embedded one.

# GUI
### Weston
Wayland 

# Audio
### Alsa
Alsa è la principale architettura audio per il sistema operativo linux. La sua customizzazione propone la creazione di profili per gestire i diversi canali audio ed il loro comportamento. 

# Integration
Come precedentemente discusso il progetto mira, oltre alla customizzazione della distro stessa anche la semplificazione dell integrazione di applicativi di ogni genere.
Fin ora gli applicativi correttamente integrati compongono:
1. C applications
2. C++ applications
3. QT applications
4. Qt/QML applications
5. Kernel Modules

# IPC
### ZeroMQ
services and applications exchanging messages through a flaxible interprocess communication based on ZeroMQ. This way applications written with any language could exchange rapidly informations and work as a single application. 

# Develop your application


# How to build
bunch-linux derives directly from poky by extending and customizing the known distro already included in the Yocto project if necessary.
Google repo tool is needed to collect the sources and start the build process. To build from sources you can init the repo to the manifest and synchronize the sources easily. Repo tool will download the sources and configure the environment for you. 
<<codice >> 
Once the environment is properly set you should source to the setup-environment script and then launch the compilation of the distro using bitbake yocto tool.
<<codice >>
The compiled image will be located into the build folder at the following path
"""/build/tmp/deploy/images/raspberrypi4-64"""
Getting the image it should be flashed through linux dd command or using third party software like BalenaEtcher, Raspberry Imager

