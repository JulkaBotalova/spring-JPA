package test;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rcontroller {

   /* private final TestRepository testRepository;
    private final Test2Repository test2Repository;

    public Rcontroller(TestRepository testRepository, Test2Repository test2Repository) {
        this.testRepository = testRepository;
        this.test2Repository = test2Repository;
    }


    @RequestMapping("Controller")
    public TestEntity controller (@RequestParam(name  = "name", defaultValue = "") String name){

        TestEntity ent = new TestEntity();

        ent.setName(name);
        ent.setTest2s(new HashSet<Test2>());

        for (Integer i=0; i<5; i++){

            Test2 t2 = new Test2();

            t2.setName("Наименование" + i.toString());
            t2.setTestEntity(ent);
            ent.getTest2s().add(t2);

        }

        testRepository.save(ent);
        test2Repository.saveAll(ent.getTest2s());

        return ent;



    }*/

}
