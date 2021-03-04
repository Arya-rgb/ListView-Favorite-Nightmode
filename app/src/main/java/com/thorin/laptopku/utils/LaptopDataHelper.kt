package com.thorin.laptopku.utils

import ListLaptop


class LaptopDataHelper{
    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var laptopList = ArrayList<ListLaptop>()

            laptopList.add(ListLaptop("Asus X441BA", "Rp 4.800.000","""
                Laptop ini didesain khusus bagi mereka yang membutuhkan notebook untuk menangani kebutuhan sehari-hari dengan harga yang terjangkau. Ia dilengkapi prosesor AMD Dual-Core A4 seri 9125 generasi Stoney Ridge dan RAM 4GB DDR4.
                Penampilan atau desain fisik Asus X441BA ini cukup menarik di kelasnya dengan lekukan yang elegan khas ASUS. Laptop ini juga dibalut dengan casing solid dengan warna cokelat/brown yang menambah kesan mewah.
            """.trimIndent(),"""
                Spesifikasi:
                Display: 14 inci, 1.366 x 768 piksel
                Processor: AMD Dual Core A4-9125
                RAM: 4GB DDR4
                HDD: 500GB
                Detail OS: Windows 10 Home
                Graphics: AMD Radeon R4 Graphics
                Optical Drive Type: DVD+RW
                Camera: VGA Web camera
                Audio: Built-in Stereo 3 W Speakers And Microphone
                Baterai: 45 W, 3 Cells, 36 Whrs
                
            """.trimIndent(),"https://i.ibb.co/MDQQWmL/Asus-X441-BA.png"))
            laptopList.add(ListLaptop("Asus X441MA", "Rp 4.349.000","""
                Asus X441MA merupakan laptop entry-level yang ditenagai oleh prosesor Intel Celeron N4000 Processor, memori RAM 4GB DDR3, dan ruang penyimpanan HDD 1TB 5400RPM. Laptop ini cukup untuk komputasi sehari-hari yang biasa dipakai untuk pelajar atau mahasiswa.
                Laptop ini juga dirancang untuk memberikan pengalaman multimedia yang mendalam dengan kombinasi teknologi audio Asus SonicMaster dengan teknologi ICEpower, yang mampu menghasilkan suara sejernih kristal.
            """.trimIndent(),"""
                Spesifikasi:
                Display: 14 inch LED Backlit, 1.366 x 768 piksel
                Processor: Intel Celeron Processor N4000
                RAM: 4GB DDR4
                HDD: 1 TB
                Detail OS: Windows 10
                Graphics: Intel HD Graphics
                Optical Drive Type: Super Multi DVD
                Keyboard: Chiclet keyboard
                Camera: VGA Webcam
                Audio: ASUS SonicMaster Technology
                Baterai: 3 -Cell, 36 Wh
                
            """.trimIndent(),"https://i.ibb.co/f0rkf7f/Asus-X441-MA.png"))
            laptopList.add(ListLaptop("Asus VivoBook E203 MAH", "Rp 4.912.000","""
                Laptop ini ditenagai oleh prosesor Intel Celeron N4000, RAM 4GB DDR4, dan HDD SATA 500GB, Asus E203 MAH bisa dibilang cukup menjanjikan, baik dari sisi harga yang terjangkau dan juga spesifikasi yang lumayan bagus.
                Layar laptop ini 11.6 inch dengan resolusi HD, 1366 x 768, layarnya yang lebih kecil dari laptop 14 inch lainnya Ini membuat tampilan layarnya jadi lebih bersih dan jernih.
            """.trimIndent(),"""
                Spesifikasi:
                Display: TFT LCD LED backlight 11,6 inci, 1.366 x 768 piksel
                Processor: Intel Celeron Processor N4000 (4M Cache, Up to 2.60 GHz)
                RAM: 4GB DDR4
                HDD: 500GB
                Detail OS: Windows 10
                Graphics: Intel UHD Graphics 600
                Keyboard: Chiclet keyboard
                Camera: VGA Webcam
                Audio: ASUS SonicMaster Technology
                Baterai: 3 Cells, 42 Whrs Polymer
                
            """.trimIndent(),"https://i.ibb.co/M8TPTMJ/Asus-Vivo-Book-E203-MAH.png"))
            laptopList.add(ListLaptop("Asus A407MA", "Rp 4.750.000","""
                Asus A407MA merupakan laptop entry level yang memiliki prosesor intel N4000 dan VGA Intel HD Graphic. Walaupun tidak semewah pendahulunya, Asus A407UA dan A407UB yang memiliki spec lebih tinggi.
                Laptop Asus A407MA tetap memiliki penampilan yang hampir mirip dan sama-sama terlihat menarik dengan balutan warna yang elegan, Stary Grey & Icecle Gold.
            """.trimIndent(),"""
                Spesifikasi:
                Display: 14, inci (16:9) LED backlit HD 1.366 x 768 piksel
                Processor: Intel Celeronm N4000 Processor (4 M Cache, up to 2.6 GHz)
                RAM: 4 GB DDR4 2400MHz DDR4
                HDD: 1TB 5400 rpm SATA HDD
                Detail OS: Windows 10 Home
                Graphics: Integrated Intel UHD Graphics 600
                Webcam: VGA Webcam
                Audio: Built-in 2 W Stereo Speakers with Microphone, Built-in 2 W Stereo Speakers with Microphone
                Battery: 3 -Cell, 33 Wh Battery
                
            """.trimIndent(),"https://i.ibb.co/HhDjPns/A407-MA-BV001-T-removebg-preview.png"))
            laptopList.add(ListLaptop("Lenovo IdeaPad 130", "Rp 3.799.000","""
                Lenovo IdeaPad 130 14AST punya layar berukuran 14 inci dengan teknologi TFT LCD LED backlight dengan resolusi HD dan sudah dilengkapi dengan anti-glare.
                Walaupun dimensi laptop ini terbilang masih cukup kompak dan dapat mendukung mobilitas pengguna, laptop ini belum menggunakan desain slim bezel yang modern.
                Dari segi performa, prosesor yang digunakan adalah AMD APU  A4-9125 yang merupakan APU generasi ketujuh yang dapat berlari di kecepatan 2,3GHz sampai 2,6GHz.
            """.trimIndent(),"""
                Spesifikasi:
                Display: 14,0 inci, 1.366 x 768 piksel
                Processor: AMD A4-9125 Processor (2.30 – 2.60 GHz, 1 MB Cache)
                RAM: 4 GB DDR4
                HDD: 500 GB
                Detail OS: Windows 10 Home
                Graphics: AMD Radeon R3 Graphics
                Optical Drive Type: DVD-RW
                Camera: 0.3MP with Microphone
                Audio: 2 x 1.5 W speakers with Dolby Audio
                Battery: 2-Cell
                
            """.trimIndent(),"https://i.ibb.co/Xxs17RX/Lenovo-Idea-Pad-130-3-removebg-preview.png"))
            laptopList.add(ListLaptop("Acer Aspire 3 A315-42-R3GZ", "Rp 7.799.000","""
               Acer Aspire 3 A315-42-R3GZ dengan prosesor AMD Ryzen 5 bisa menjadi andalan tangguh bagi yang mencari laptop gaming murah seharga Rp 7 jutaan.
               Dengan harga tersebut, kamu juga telah bisa menikmati grafis andal dari AMD, penyimpanan dan random access memory (RAM) besar hingga dua built-in stereo untuk kepuasan audio.
            """.trimIndent(),"""
                Spesifikasi:
                Layar: 15,6 inci, resolusi 1.366 x 768 piksel
                Prosesor: AMD Ryzen 5 3500U (2.1 GHz – 3.7 GHz, 4 MB L3 cache)
                Grafis: AMD Radeon Vega 8
                RAM: 8 GB (2 x 4 GB)
                Storage: HDD 1 TB
                
            """.trimIndent(),"https://i.ibb.co/nrfsjFf/Acer-Aspire-3-A315-42-R3-GZ-removebg-preview.png"))
            laptopList.add(ListLaptop("Acer Predator Nitro 5 AN515-43", "Rp 11.999.000","""
              Acer Predator Nitro 5 varian AN515-43 dengan AMD Ryzen 5 generasi ketiga sangat bisa diandalkan untuk melibas permainan favoritmu.
              Hal ini juga dimungkinkan berkat dukungan pengolah grafis tangguh dari AMD, yaitu AMD Radeon RX 560X yang memiliki kinerja ciamik dengan kecepatan inti hingga 1,275 GHz (boost).
            """.trimIndent(),"""
                Spesifikasi:
                Layar: 15,6 inci, resolusi 1.920 x 1.080 piksel
                Prosesor: AMD Ryzen 5 3550H (2.1 GHz – 3.7 GHz, 4 MB L3 cache)
                Grafis: AMD Radeon RX 560X
                RAM: 8 GB
                Storage: HDD 1 TB
                
            """.trimIndent(),"https://i.ibb.co/prSHJsm/an515-43.png"))
            laptopList.add(ListLaptop("Asus TUF FX505DD R5598T", "Rp 10.499.000","""
              Acer Predator Nitro 5 varian AN515-43 dengan AMD Ryzen 5 generasi ketiga sangat bisa diandalkan untuk melibas permainan favoritmu.
              Hal ini juga dimungkinkan berkat dukungan pengolah grafis tangguh dari AMD, yaitu AMD Radeon RX 560X yang memiliki kinerja ciamik dengan kecepatan inti hingga 1,275 GHz (boost).
            """.trimIndent(),"""
                Spesifikasi:
                Layar: 15,6 inci, resolusi 1.920 x 1.080 piksel (120 Hz)
                Prosesor: AMD Ryzen 5 3550H (2.1 GHz – 3.7 GHz, 4 MB L3 cache)
                Grafis: Nvidia GeForce GTX 1050
                RAM: 8 GB
                Storage: SSD 512 GB
                
            """.trimIndent(),"https://i.ibb.co/G7FyPwS/3-Asus-TUF-FX505-DD-R5598-T-300x300-removebg-preview.png"))
            laptopList.add(ListLaptop("Asus VivoBook Pro F571GD-BQ5801T", "Rp 10.999.000","""
              Tak hanya seri TUF yang bisa diandalkan untuk kebutuhan game, Asus juga memiliki laptop VivoBook untuk kamu yang mencari laptop gaming dengan harga terjangkau.
              Asus VivoBook Pro F571GD-BQ5801T memiliki desain layaknya laptop ‘normal,’ namun menawarkan performa yang kencang dan efisien berkat Intel Core i5 generasi versi Coffee Lake.
            """.trimIndent(),"""
                Spesifikasi:
                Layar: 15,6 inci, resolusi 1.920 x 1.080 piksel
                Prosesor: Intel Core i5 9300H (2.40 GHz – 4.1 GHz, 8 MB L3 cache)
                Grafis: Nvidia GeForce GTX 1050
                RAM: 8 GB
                Storage: SSD 512 GB
                
            """.trimIndent(),"https://i.ibb.co/PtnSGC2/4-Asus-Vivo-Book-Pro-F571-GD-BQ5801-T-300x300-removebg-preview.png"))
            laptopList.add(ListLaptop("Lenovo IdeaPad S340-14API", "Rp 8.499.000","""
              Satu lagi model laptop unggulan dari Lenovo dengan harga terjangkau untuk gaming, yakni IdeaPad S340-14API.
              Lenovo IdeaPad S340-14API dengan AMD Ryzen 5 dan grafis Radeon Vega 8 mungkin adalah salah satu yang termurah yang bisa dijadikan pilihan menarik.
            """.trimIndent(),"""
                Spesifikasi:
                Layar: 14 inci, resolusi 1.920 x 1.080 piksel
                Prosesor: AMD Ryzen R5 3500U (2.10 GHz – 3.70 GHz, 6 MB L3 cache)
                Grafis: AMD Radeon Vega 8
                RAM: 8 GB
                Storage: SSD 512 GB
                
            """.trimIndent(),"https://i.ibb.co/rmBJ3HL/ezgif-com-webp-to-jpg-removebg-preview.png"))
            return laptopList as ArrayList
        }
    }
}