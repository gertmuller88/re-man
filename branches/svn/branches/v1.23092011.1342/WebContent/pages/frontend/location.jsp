<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/1998/REC-html40-19980424/loose.dtd"> 
<html lang="pt-BR"> 
	<head> 
		<meta name="author" content="Gert Uchôa Müller Neto, B.Sc."> 
		<meta name="keywords" content="Information Systems, Computer Engineering, Computer Science"> 
		<meta name="description" content="Gert Uchôa Müller Neto Personal Page"> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no"> 
		<link rel="shortcut icon" href="img/favicon.ico"> 
		<link href="css/gumn.css" rel="stylesheet" type="text/css"> 
		<link href="http://code.google.com/apis/maps/documentation/javascript/examples/default.css" rel="stylesheet" type="text/css"> 
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&amp;region=BR"></script> 
		<title>Gert Uchôa Müller Neto, B.Sc.</title> 
		
		<script type="text/javascript"> 
			var geocoder;
			var map;
			var query = "Av. Jornalista Aníbal Fernandes, s/n, 2º Andar, Cidade Universitária, 50.740-560 - Recife, PE - Brasil";
			function initialize()
			{
				geocoder = new google.maps.Geocoder();
				var myOptions = {
					zoom:14,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				}
			map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
			codeAddress();
			}
			
			function codeAddress()
			{
				var address = query;
				geocoder.geocode( { "address": address}, function(results, status) {
					if (status == google.maps.GeocoderStatus.OK)
					{
						map.setCenter(results[0].geometry.location);
						var marker = new google.maps.Marker({
							map: map, 
							position: results[0].geometry.location
						});
					}
					else
					{
						alert("Geocode was not successful for the following reason: " + status);
					}
				});
			}
		</script> 
	</head> 
	
	<body onload="initialize()"> 
		<div id="map_canvas"></div> 
	</body> 
</html>