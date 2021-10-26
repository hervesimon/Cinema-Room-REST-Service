/**
    Box for cakes
*/
class CakeBox extends Box<Cake>{
}

/**
    Box for pies
*/
class PieBox extends Box<Pie>{
}


/**
    Box for tarts
*/
class TartBox extends Box<Tart>{
}

/*
    Hundred more such boring classes OR ...
    magic class for everything everybody is waiting for
*/
class Box<T> {
    private T pastry;
    public void put(T pastry) {
        this.pastry = pastry;
    }
    public T get() {
        return this.pastry;
    }
}

// Don't change classes below
class Cake { }

class Pie { }

class Tart { }