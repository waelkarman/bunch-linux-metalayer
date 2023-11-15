# bunch-linux-metalayer

Notes:
WLAN connection is working but should be set up manually:<br>
- list interfaces:<br>
> ip link show<br>
- enable wlan interface:<br>
> ip link set wlan0 up<br>

populate /etc/wpa_supplicant.conf like:

> ctrl_interface=/var/run/wpa_supplicant<br>
> ctrl_interface_group=0<br>
> update_config=1<br>
> 
> network={<br>
>         ssid="FRITZ!Box 7583 KW"<br>
>         scan_ssid=1<br>
>         key_mgmt=WPA-PSK<br>
>         psk="insert here your password"<br>
> }<br>

> wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant.conf<br>
> udhcpc -i wlan0<br>


For cross compiling add to image feature: tools-sdk <br>
For compiling on the embedded dev: dev-pkgs
