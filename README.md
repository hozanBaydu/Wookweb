# Wookweb
## Özellikler




https://user-images.githubusercontent.com/113553307/206592695-bae00acc-dded-4288-aede-04c8dd1c37f3.mp4



- Kullanıcı istediği hizmet için ana ekranda seçim yapabilir.
- Seçilen izmet otomatik olarak hafızaya kaydedilir.
- Kullanıcı gönder buttonuna tıklayınca bilgiler otomatik bir şekilde oluşturulur.

Not:Yazının okunma süresi 2 dakikadır.


### Ana Ekran

![wookk1](https://user-images.githubusercontent.com/113553307/206589090-e319649a-0c92-4e50-9c7f-83921cc2a52b.png)

Kullanıcı bu ekrandan istediği 6 hizmetten birini seçerek hizmetin ayrıntılarına yönlendirilir.



```sh
lifecycleScope.launch {
            var i=0
            var check=true
            while (i<20) {
                if (check){
                    binding.animImageView.setImageResource(R.drawable.luxuriousimage)
                binding.animImageViewTextview.setImageResource(R.drawable.luxurioustext)

                    val buttonAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation)
                    binding.animImageView.startAnimation(buttonAnimation)

                    check=false
                    i++
                    delay(3000)
                }else{
                    binding.animImageView.setImageResource(R.drawable.creativity)
                    binding.animImageViewTextview.setImageResource(R.drawable.creativityimagetext)

                    val buttonAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.animation)
                    binding.animImageView.startAnimation(buttonAnimation)
                    check=true
                    i++
                    delay(3000)
                }
            }
        }
```
Yukarıdaki kodlar sayfadaki görünümler ve animasyonlar için yazılmıştır.

### Hizmet Ekranları

Bu ekranlarda kullanıcı için tıklanan hizmetin ayrıntıları yer almaktadır.
Örnek olarak aşağıdaki SEO fragmentini inceleyebilirsiniz.

![wookk2](https://user-images.githubusercontent.com/113553307/206589476-f59db014-56ea-4b1d-91ac-62e45f3908a9.png)


Tıklanan hizmeti teklif ekranına aktarmak için viewmodelde bir  MutableStateFlow değişken tanımladım.


```sh
 var textName= MutableStateFlow("textName")
```

Örnek olarak SEO fragmentinden teklif alınmak istendiğinde aşağıdaki kod sayesinde viewmodelde tanımladığımız textNamenin değeri değişir.
```sh
binding.seoTeklifalButton.setOnClickListener {
            viewModel.textName.value="SEO"
            findNavController().navigate(SeoFragmentDirections.actionSeoFragmentToOfferFragment())
        }
```


### Teklif Ekranı

![wookk3](https://user-images.githubusercontent.com/113553307/206589795-1e9bec9e-34e5-43db-956f-a02a05c9acef.png)


TextNamenin değerini teklif alma ekranında aşağıdaki kod parçası sayesinde alıp textviewde kullanıcıya gösteriyoruz.

```sh
lifecycleScope.launch {
            viewModel.textName.collect{
                binding.teklifImageview.text=it
            }
        }

```

MutableStateFlow değişkenleri doğrudan gözlemleyemediğimiz için lifecycleScope.launch kullandım.

Ardından isim,mail ve özet değerlerini aldıktan sonra aşağıdaki kodlar sayesinde gönder butonuna tıklanınca hazır mesaj şeklinde gönderilebilir hale getiriyoruz.

```sh
 binding.gonderbutton.setOnClickListener {
            var message="Konu= " + binding.teklifImageview.text.toString()+ " - " + " Ad= "+binding.adTextview.text.toString()+
                    " - " + " Mail= " + binding.mailTextview.text.toString() + " - " + " Özet= " + binding.ozetTextview.text.toString()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.type = "text/plain"
            intent.setPackage("com.whatsapp")
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone=905456053279&text="+message))
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(intent)
        }
```

Uygulamayı yazan:Hozan BAYDU

Tasarım:Adobexd,Canva

Tarih:20.11.2022

iletişim:hozan.baydu3447@gmail.com
