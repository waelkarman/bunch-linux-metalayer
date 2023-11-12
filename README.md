# bunch-linux-metalayer
Bunch linux is a project created for learning purposes. The idea is to fully understand the foundations of systems and applications starting from the lowest possible level. 


Notes:
To develop using qtcreator directly looks needed to add inherit populate_sdk_qt5 into the image and TOOL_SDK:append " qtbase qt declarative" into the local.conf

- list interfaces: ip link show
- enable wlan interface: ip link set wlan0 up

populate /etc/wpa_supplicant.conf like:

> ctrl_interface=/var/run/wpa_supplicant<br>
> ctrl_interface_group=0<br>
> update_config=1<br>
> 
> network={<br>
>         ssid="FRITZ!Box 7583 KW"<br>
>         scan_ssid=1<br>
>         key_mgmt=WPA-PSK<br>
>         psk="23587684732970795127"<br>
> }<br>

- wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant.conf
- udhcpc -i wlan0
