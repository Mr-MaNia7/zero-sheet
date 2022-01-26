package com.webproject.zerosheet;


import com.webproject.zerosheet.inventory.Item;
import com.webproject.zerosheet.inventory.ItemRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZeroSheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeroSheetApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataSeeder(ItemRepository itemrepo) {
		return args -> {
			itemrepo.save(new Item(1L, "H frame 2.4 ( ኤች ፍሬም)", "PCS", 3.84d, 3.50d, 100, 23, 23
				));
			itemrepo.save(new Item(2L, "X-bracing (ኤክስ መወጠሪያ)", "PCS", 3.84d, 4.50d, 120, 34, 3 
				));
			itemrepo.save(new Item(3L, "U-head (አናት)", "PCS", 4.45d, 3.50d, 120, 33, 23
				));
			itemrepo.save(new Item(4L, "Base juck (እግር)", "PCS", 4.85d, 3.84d, 100, 23, 12 
				));
			itemrepo.save(new Item(5L, "Connector ( ማገናኛ)", "PCS", 4.45d, 3.55d, 100, 22, 12
				));
			itemrepo.save(new Item(6L, "Extention1m (ማራዘሚያ1ሜ)", "PCS", 3.50d, 3.50d, 120, 11, 11
				));
			itemrepo.save(new Item(7L, "Extention50cm (ማራዘሚያ50ሤሜ)", "PCS", 2.85d, 2.50d, 80, 12, 21
				));
			itemrepo.save(new Item(8L, "Clamp free (ክላምፕ ነጻ)", "PCS", 2.5d, 2.80d, 70, 11, 0
				));
			itemrepo.save(new Item(9L, "Clamp 90° (ክላምፕ 90°)", "PCS", 2.45d, 3.50d, 90, 12, 0
				));
			itemrepo.save(new Item(10L, "Clamp connector(ክላምፕ ማገናኛ)", "PCS", 1.45d, 1.50d, 50, 0, 0
				));
			itemrepo.save(new Item(11L, "CHSØ48*3mm 6m(ክብ ቱቦ 48*2)", "PCS", 5.50d, 5.55d, 120, 0, 0
				));
			itemrepo.save(new Item(12L, "CHSØ48*2mm 2m(ክብ ቱቦ 48*2)", "PCS", 4.45d, 3.50d, 120, 0, 0
				));
			itemrepo.save(new Item(13L, "Platform board(መቆሚያ ፓኔል)", "PCS", 8.5d, 7.50d, 100, 0, 0
				));
			itemrepo.save(new Item(14L, "Shoring Props (ቋሚ )", "PCS", 12.45d, 22.50d, 120, 0, 0
				));
			itemrepo.save(new Item(15L, "RHS 60*60*3(ሬክታንግል ቱቦ60*60*3)", "PCS", 11.22d, 15.0d, 120, 0, 0
				));
		};
	}

}
