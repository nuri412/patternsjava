public class Main {

    public interface WeaponBehavior {
        void useWeapon();
    }

    // стратегия1
    public static class SwordBehavior implements WeaponBehavior {
        @Override
        public void useWeapon() {
            System.out.println("Удар мечом!");
        }
    }

    // стратегия2
    public static class BowBehavior implements WeaponBehavior {
        @Override
        public void useWeapon() {
            System.out.println("Выстрел из лука!");
        }
    }

    // Класс контекста
    public static class GameCharacter {
        private WeaponBehavior weapon;

        public GameCharacter(WeaponBehavior initialWeapon) {
            this.weapon = initialWeapon;
        }

        public void setWeapon(WeaponBehavior newWeapon) {
            this.weapon = newWeapon;
        }

        public void attack() {
            weapon.useWeapon();
        }
    }

    public static void main(String[] args) {
        // Создаем персонажа с мечом
        GameCharacter character = new GameCharacter(new SwordBehavior());
        character.attack();  // Удар мечом!

        // Меняем оружие на лук
        character.setWeapon(new BowBehavior());
        character.attack();  // Выстрел из лука!
    }
}