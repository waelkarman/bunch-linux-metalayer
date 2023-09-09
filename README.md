# Bunch Linux purpose
Bunch linux is a project created for educational purposes. The goal is to learn how to build your own custom version of linux for Embedded Systems as well as the well-known goal of every developer, have fun!
The project also acts as an entry point for those who want to approach the embedded world for business reasons or even just to fully understand the foundations of systems and applications starting from the lowest possible level. The Idea it's also to get in the end an easy way for fully customize an embedded device by getting the user able to customize eniterly the distro acting on a singular recipe.  

Bunch Linux was built over the Yocto project and it's currently based on "kirkston". Starting from poky distro day by day is getting way more customized by adding new feature, support more sensors and hardware. The project targets to be working out of the box. The sources had been defined in a manifest and will be collected by Google Repo Tool that will download the sources and setup the directory ready for start building the system. To setup the environment and start building the system should be sourced the setup-environment shell script that could be found in the source folder     




# GUI
### Weston
Native weston interface had been customized with some patches to create a nice HMI and QtWayland had been installed to allow Qt applications to be managed by the compositor. 



# Integration
As mentioned the intent is not so much the production of applications that work on an Embedded System as the possibility of porting any application to an embedded one.
1. C/C++ applications
2. Python applications
3. Qt/QML applications
4. Kernel Modules
5. MPI library

# IPC
### ZeroMQ
services and applications exchanging messages through a flaxible interprocess communication based on ZeroMQ. This way applications written with any language could exchange rapidly informations and work as a single application. 

# How to build
bunch-linux derives directly from poky by extending and customizing the known distro already included in the Yocto project if necessary.
Google repo tool is needed to collect the sources and start the build process. To build from sources you can init the repo to the manifest and synchronize the sources easily. Repo tool will download the sources and configure the environment for you. 
<<codice >>
Once the environment is properly set you should source to the setup-environment script and then launch the compilation of the distro using bitbake yocto tool.
<<codice >>
The compiled image will be located into the build folder at the following path
"""/build/tmp/deploy/images/raspberrypi4-64"""
Getting the image it should be flashed through linux dd command or using third party software like BalenaEtcher, Raspberry Imager.


# Develop your application
per vedere tutti task eseguiti durante il processo di compilazione è possibile usare il comando 
bitbake -g bunch-linux -u taskexp

