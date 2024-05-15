package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */
        if (partRepository.count() == 0) {

            InhousePart blkDial = new InhousePart();
            blkDial.setName("BlackDial");
            blkDial.setPrice(99.99);
            blkDial.setInv(15);

            InhousePart slvrDial = new InhousePart();
            slvrDial.setName("SilverDial");
            slvrDial.setPrice(199.99);
            slvrDial.setInv(10);

            InhousePart gldDial = new InhousePart();
            gldDial.setName("GoldDial");
            gldDial.setPrice(299.99);
            gldDial.setInv(5);

            InhousePart slvrBezel = new InhousePart();
            slvrBezel.setName("SilverBezel");
            slvrBezel.setPrice(19.99);
            slvrBezel.setInv(15);

            InhousePart gldBezel = new InhousePart();
            gldBezel.setName("GoldBezel");
            gldBezel.setPrice(29.99);
            gldBezel.setInv(15);

            InhousePart ttnmBezel = new InhousePart();
            ttnmBezel.setName("TitaniumBezel");
            ttnmBezel.setPrice(39.99);
            ttnmBezel.setInv(10);

            partRepository.save(blkDial);
            partRepository.save(slvrDial);
            partRepository.save(gldDial);
            partRepository.save(slvrBezel);
            partRepository.save(gldBezel);
            partRepository.save(ttnmBezel);
        }

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart blkStrap = new OutsourcedPart();
            blkStrap.setName("BlackStrap");
            blkStrap.setPrice(9.99);
            blkStrap.setInv(15);
            blkStrap.setCompanyName("Delugs");

            OutsourcedPart slvrStrap = new OutsourcedPart();
            slvrStrap.setName("SilverStrap");
            slvrStrap.setPrice(19.99);
            slvrStrap.setInv(10);
            slvrStrap.setCompanyName("Delugs");

            OutsourcedPart gldStrap = new OutsourcedPart();
            gldStrap.setName("GoldStrap");
            gldStrap.setPrice(29.99);
            gldStrap.setInv(10);
            gldStrap.setCompanyName("Delugs");

            OutsourcedPart wdnCase = new OutsourcedPart();
            wdnCase.setName("WoddenCase");
            wdnCase.setPrice(24.99);
            wdnCase.setInv(10);
            wdnCase.setCompanyName("Delugs");

            OutsourcedPart mtlCase = new OutsourcedPart();
            mtlCase.setName("MetalCase");
            mtlCase.setPrice(29.99);
            mtlCase.setInv(10);
            mtlCase.setCompanyName("Delugs");

            outsourcedPartRepository.save(blkStrap);
            outsourcedPartRepository.save(slvrStrap);
            outsourcedPartRepository.save(gldStrap);
            outsourcedPartRepository.save(wdnCase);
            outsourcedPartRepository.save(mtlCase);
        }

        if (productRepository.count() == 0 ) {

            Product clscBlack = new Product("Classic Black", 199.99, 15);
            Product clscSilver = new Product("Classic Silver", 299.99, 15);
            Product clscGold = new Product("Classic Gold", 399.99, 15);
            Product bldTitanium = new Product("Bold Titanium", 499.99, 15);
            Product bldGold = new Product("Boldie Goldie", 599.99, 15);

            productRepository.save(clscBlack);
            productRepository.save(clscSilver);
            productRepository.save(clscGold);
            productRepository.save(bldTitanium);
            productRepository.save(bldGold);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
