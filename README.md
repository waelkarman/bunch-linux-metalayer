# Welcome to Bunch Linux
![alt text](https://github.com/waelkarman/bunch-linux-manifests/blob/master/miscellaneous/wayland-screenshot-turtle.png?raw=true)
Bunch Linux is a project created for learning purposes. The goal is to learn how to build your own custom version of Linux for Embedded Systems as well as the well-known goal of every developer, have fun!
The idea is to fully understand the foundations of systems and applications starting from the lowest possible level. The aim it's also to get in the end an easy way for fully customize an embedded device.  

Bunch Linux was built over the Yocto project and it's currently based on *kirkstone*. Starting from poky distro is slowly getting way more customized by adding new feature, support more sensors and hardware. The project targets to be working out of the box. The sources had been defined in a manifest and will be collected by *Google* *Repo* *Tool* that will download the sources and setup the directory ready to start building the system. 

## System
The system uses U-Boot as the bootloader, handling the boot sequence. *systemd* has been used as the init program, and the primary data reading and communication services have been added to startup depending on the main target *multi-user.target*.
To view the entire system boot services, you can use the following command: <br/>
> systemctl list-units --type=service --all

## HMI
##### Weston
Native weston interface had been customized with some patches to create a nice HMI and *QtWayland* had been installed to allow Qt applications to be managed by the compositor. 

![alt text](https://github.com/waelkarman/bunch-linux-manifests/blob/master/miscellaneous/qtappwaylandalpha.png?raw=true)

To get *weston* manage the qt application should be set the variable *QT_QPA_PLATFORM* to wayland or just using the option *--platform wayland* launching the app.

## Audio
##### ALSA + PipeWire 
WORK IN PROGRESS (..)

# Integration
As mentioned, the intent the possibility of porting any application to an embedded one. Currently integrated ones:<br/>
1. C/C++ applications<br/>
2. Python applications<br/>
3. Qt/QML applications<br/>
4. Kernel Modules<br/>

## IPC
##### ZeroMQ
services and applications exchanging messages through a flexible interprocess communication based on [ZeroMQ](https://zeromq.org/). This way applications written with any language could exchange rapidly information and work as a single application. The interesting aspect of ZMQ is that the message exchanging is based on network protocols that allow any node over the network to be reached. 
For the specific case, the following are the available messaging exchange models:<br/>
Request–Reply<br/>
Publish–Subscribe<br/>

In the following diagram, the communication schema of the sensors-app already installed on the system is shown.

![alt text](https://github.com/waelkarman/bunch-linux-manifests/blob/master/miscellaneous/sensorappcommunication.png?raw=true)

Similar to any advanced embedded device like an infotainment, a dashboard and so forth the *sensor-app* allows the users to check the status of the supported sensors and to control it directly from the GUI. 

The app is developed in Qt, while the services are implemented in Python and C++. The Python services rely on the pi-blaster and raspi-gpio libraries, while the C++ services utilize a custom library that directly writes to the SYS filesystem of the operating system, corresponding to the following operations:
> echo [numGPIO] \> /sys/class/gpio/export<br/>
> echo out > /sys/class/gpio/gpio[numGPIO]/direction<br/>
> echo 1 > /sys/class/gpio/gpio[numGPIO]/value<br/>


Here are examples of services utilizing interprocess communication (IPC) written in both Python and C++ that are included in the apps:<br/>
* zmqpubblisher<br/>
* zmqsubscriber<br/>
* zmqrequester<br/>
* zmqreplyer<br/>


## How to build
bunch-linux is based on poky and extending and customizing the known distro already included in the Yocto project if necessary.
*Google* *repo* *tool* is needed to collect the sources and start the build process. To setup the environment and start building the system should be sourced the *setup-environment* shell script that could be found in the source folder.  To build from sources you can init the repo to the *manifest* and synchronize the sources easily. Repo tool will download the sources and configure the environment for you.<br/> 
> repo init -u https://\<TOKEN\>@github.com/waelkarman/bunch-linux-manifests.git -m v6.3.0.xml -b master<br/>
> repo sync<br/>
 
Once the environment is properly set you should source to the *setup-environment* script and then launch the compilation of the distro using *bitbake* yocto tool.
> source setup-environment<br/>
> bitbake bunch-linux<br/>

The compiled image will be located into the build folder at the following path:
> /build/tmp/deploy/images/raspberrypi4-64

Getting the image it should be flashed through linux dd command or using third party software like *BalenaEtcher*, *Raspberry* *Imager*.


## Develop and build your application

After developing an app into a git repo use the following command to add it to the system:
> devtool add \<url\> 

If you d'like to do some local test you can do it by using devtool as following:
> devtool modify \<recipename\>

To integrate your local changes into the original recipe as patch use devtool as following:
> devtool update-recipe \<recipename\>

To integrate your local changes into another layer as patch to a recipe use devtool as following:
> devtool update-recipe -a \<layerpath\> \<recipename\>

To reset the status of your recipe:
> devtool reset \<recipename\>


To check all the task through the compilation process : 
> bitbake -g bunch-linux -u taskexp 

To read the environment of a specific recipe use bitbake as following:
> bitbake -e \<recipename\> | grep \<VARIBLE\>
