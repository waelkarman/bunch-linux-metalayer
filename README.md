# Welcome to Bunch Linux
Bunch linux is a project created for educational purposes. The goal is to learn how to build your own custom version of linux for Embedded Systems as well as the well-known goal of every developer, have fun!
The project also acts as an entry point for those who want to approach the embedded world for business reasons or even just to fully understand the foundations of systems and applications starting from the lowest possible level. The Idea it's also to get in the end an easy way for fully customize an embedded device by getting the user able to customize eniterly the distro acting on a singular recipe.  

Bunch Linux was built over the Yocto project and it's currently based on "kirkston". Starting from poky distro day by day is getting way more customized by adding new feature, support more sensors and hardware. The project targets to be working out of the box. The sources had been defined in a manifest and will be collected by Google Repo Tool that will download the sources and setup the directory ready for start building the system. 

## System
L' Il sisitema utiliazza u-boot come bootloader gestendo la sequenza di avvio 
systemd è stato usato come init program e i principali servizi di lettura dati e comunicazione sono stati aggiunti all avvio sul target principale multi-user.target. 
per vedere tutta la sequenza di avvio del sistema: 
systemctl list-units --type=service --all


## GUI
##### Weston
Native weston interface had been customized with some patches to create a nice HMI and QtWayland had been installed to allow Qt applications to be managed by the compositor. 

![alt text](https://github.com/waelkarman/bunch-linux-metalayer/blob/master/miscellaneous/qtappwaylandalpha.png?raw=true)

To get weston manage the qt application should be set the variable QT_QPA_PLATFORM to wayland or just using the option --platform wayland launching the app.

## Audio
##### ALSA is the (..)

# Integration
As mentioned the intent is not so much the production of applications that work on an Embedded System as the possibility of porting any application to an embedded one. Curretly integrated ones:<br/>
1. C/C++ applications<br/>
2. Python applications<br/>
3. Qt/QML applications<br/>
4. Kernel Modules<br/>

## IPC
##### ZeroMQ
services and applications exchanging messages through a flaxible interprocess communication based on [ZeroMQ](https://zeromq.org/). This way applications written with any language could exchange rapidly informations and work as a single application. 
In particolare al momento sono state esplorate le comunicazzioni di tipo :<br/>
Requester - Replyer<br/>
Pubblisher - Subscriber<br/>

In particolare viene mostrata nel seguente diagramma lo schema di comunicazione del app sensors installata gia sul sistema

![alt text](https://github.com/waelkarman/bunch-linux-metalayer/blob/master/miscellaneous/sensorappcommunication.png?raw=true)

L'app è realizzata in Qt mentre i servizi sono scritti in python e c++ 

degli esempi di servizi utilizzanti la comunicazione interprocesso scritti in python e in c++
sono presenti nelle app:<br/>
zmqpubblisher<br/>
zmqsubscriber<br/>
zmqrequester<br/>
zmqreplyer<br/>


## How to build
bunch-linux derives directly from poky by extending and customizing the known distro already included in the Yocto project if necessary.
Google repo tool is needed to collect the sources and start the build process. To setup the environment and start building the system should be sourced the setup-environment shell script that could be found in the source folder.  To build from sources you can init the repo to the manifest and synchronize the sources easily. Repo tool will download the sources and configure the environment for you.<br/> 
<< repo
repo sync
source setup-environment
bitbake bunch-linux >>
Once the environment is properly set you should source to the setup-environment script and then launch the compilation of the distro using bitbake yocto tool.
<<codice >>
The compiled image will be located into the build folder at the following path:<br/>
"""/build/tmp/deploy/images/raspberrypi4-64"""<br/>
Getting the image it should be flashed through linux dd command or using third party software like BalenaEtcher, Raspberry Imager.


## Develop your application
sviluppa la tua applicazione e utilizza devtool per integrate il tuo repo<br/>
devtool add <<url>><br/>
applica path al tuo repository per dei testing locali <br/>
devtool modify <<nome ricetta>><br/>
integra le motifiche nella ricetta modificata <br/>
devtool update-recipe <recipename><br/>
integra le tue modifiche come patch in un bbappend nel tuo layer custom:<br/>
devtool update-recipe -a <layerpath> <recipename><br/>
resetta lo stato della tua ricetta<br/>
devtool reset <recipename><br/>


per vedere tutti task eseguiti durante il processo di compilazione è possibile usare il comando 
bitbake -g bunch-linux -u taskexp

per leggere le variabili utilizzare nella costruzione ei singoli pacchetti 
bitbake -e <ricetta> | grep WORKDIR=
