# bunch-linux-metalayer
## System Update OTA
set the right date to be able to sign the bundle.
> date -s 'yyy/mm/gg'

## WiFi 
Notes:
connection is working but should be set up manually:<br>
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
>         ssid="insert here your SSID"<br>
>         scan_ssid=1<br>
>         key_mgmt=WPA-PSK<br>
>         psk="insert here your password"<br>
> }<br>

> wpa_supplicant -B -i wlan0 -c /etc/wpa_supplicant.conf<br>
> udhcpc -i wlan0<br>


For cross compiling add to image feature: tools-sdk <br>
For compiling on the embedded dev: dev-pkgs




printf "%q" $(mkpasswd -m sha256crypt temppw)
# TODO: REMOVE PASSWORD ASSIGNMENT FOR SERIAL IMAGE "admin"
PASSWD = "\$5\$YA7nDY0J\$th7S4jEgsrMeq45QCksPT6.gKk0Wqu3kO9xCgt7Yj43"
EXTRA_USERS_PARAMS = " \
    useradd -p '' kg; \
    usermod -p '${PASSWD}' kg; \
    usermod -p '${PASSWD}' weston; \
    usermod  -a -G sudo kg; \
"
