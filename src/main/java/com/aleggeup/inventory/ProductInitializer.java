package com.aleggeup.inventory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Iterator;

@Component
public class ProductInitializer {

    private Log logger = LogFactory.getLog(ProductInitializer.class);

    private ProductRepository productRepository;

    @Autowired
    public ProductInitializer(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void postConstruct() {
        if (productRepository.count() == 0) {
            initialize();
        } else {
            findProducts();
        }
    }

    private void initialize() {
        logger.info("-> Initializing Product list with seed data");
        productRepository.save(new Product(138l, 5053, "Aramusk Bath Soap For Men", 108.0, 108.0, "", "3 X 125 g", "aramusk-bath-soap-for-men-3-x-125-g.png", 140, 100, "Active"));
        productRepository.save(new Product(248l, 386, "Adidas Deo Ice Dive Deo Body Spray", 199.0, 199.0, "", "150 ml", "adidas-adidas-body-deo-ice-dive-150-ml.png", 130, 20, "Inactive"));
        productRepository.save(new Product(318l, 6124, "Baba Ramdev Patanjali Anti Bacterial Herbal Hand Wash Refill", 40.0, 40.0, "Hand Wash", "200 ml", "baba-ramdev-patanjali-anti-bacterial-herbal-hand-wash-refill-200-ml.png", 160, 50, "Inactive"));
        productRepository.save(new Product(432l, 5625, "Adidas Ice Dive Shower Gel", 150.0, 150.0, "Shower Gel", "250 ml", "adidas-ice-dive-shower-gel-250-ml.png", 170, 0, "Active"));
        productRepository.save(new Product(448l, 2298, "Axe Denim Cologne Talc", 115.0, 115.0, "Talc", "300 g", "1327941212-Jan30-1147.png", 180, 0, "Active"));
        productRepository.save(new Product(490l, 8909, "All Out Off Family Insect Repellent Lotion", 39.0, 39.0, "Lotion", "50 ml", "missingimagegr200.png", 190, 0, "Active"));
        productRepository.save(new Product(589l, 4202, "Baba Ramdev Patanjali Gulab Jal", 25.0, 25.0, "Galab Jal", "120 ml", "patanjali-gulab-jal-120-ml.png", 220, 0, "Active"));
        productRepository.save(new Product(722l, 8068, "Areev Melon & Peach Mild Shampoo", 275.0, 275.0, "Shampoo", "300 ml", "areev-melon-peach-mild-shampoo-v-300-ml-3.png", 200, 0, "Active"));
        productRepository.save(new Product(769l, 8152, "18 Herbs K-Oil 100% Herbal Care", 275.0, 275.0, "Hair Oil", "100 ml", "18-herbs-18-herbs-k-oil-100-herbal-care-100-ml-1.png", 210, 100, "Active"));
        productRepository.save(new Product(797l, 8273, "Baba Ramdev Patanjali Kesh Kanti Anti Dandruff Hair Cleanser With Natural Conditioner", 110.0, 110.0, "Anti Dandruff Shampoo", "200 ml", "baba-ramdev-patanjali-kesh-kanti-hair-cleanser-with-natural-conditioner-200-ml.png", 230, 22, "Active"));
        productRepository.save(new Product(901l, 3936, "Roots Hair Brush 2011", 175.0, 175.0, "Hair Brush", "1 pc", "roots-hair-brush-2011-1-pc.png", 240, 5, "Active"));
        productRepository.save(new Product(918l, 4273, "Biotique Bio Henna Fresh Powder Hair Color", 199.0, 199.0, "Powder", "90 g", "biotique-bio-henna-fresh-powder-hair-color-90-g.png", 250, 50, "Active"));
        productRepository.save(new Product(943l, 7904, "Brylcreem Anti Dandruff Aqua Oxy Hair Gel", 400.0, 40.0, "Hair Gel", "50 g", "brylcreem-brylcreem-anti-dandruff-aqua-oxy-hair-gel-50-g.png", 260, 15, "Active"));
        productRepository.save(new Product(949l, 5848, "Ayur Natural Rajasthani Heena Mehendi", 11.0, 25.0, "Mehendi", "100 gm", "ayur-natural-rajasthani-heena-mehendi-100-g.png", 270, 150, "Active"));
    }

    private void findProducts() {
        for (final Iterator<Product> iterator = productRepository.findAll().iterator(); iterator.hasNext(); ) {
            Product product = iterator.next();
            logger.info(product.toString());
        }
    }
}
