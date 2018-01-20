import requests

def upimage(str):
	url ="http://139.199.17.156:5002/iot/update"
        print(str+"正在上传中")
	file={('file',open(str,"rb"))}
	#re=requests.get("http://localhost:5002/pysent/here")
	#print(re.json())

	r = requests.post(url, files=file)

	print(r.json());
