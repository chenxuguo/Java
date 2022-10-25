package generics.storycharacter;

import generics.Generator;

import java.util.Random;

public class StoryCharacterGenerator implements Generator<StoryCharacter> {
    private Class[] types = {BadGuy.class, GoodGuy.class};
    private Random rand = new Random(47);
    public StoryCharacter next() {
        try {
            return (StoryCharacter) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args){
        StoryCharacterGenerator cha = new StoryCharacterGenerator();
        for(int i = 0; i < 10; i++)
            System.out.println(cha.next());
    }
}
