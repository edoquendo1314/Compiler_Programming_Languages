final class FunVal extends Val
{
    String funName;

    FunVal(String i)
    {
        this.funName = i;
    }

    @Override
    Val cloneVal()
    {
        return new FunVal(funName);
    }

    @Override
    float floatVal() {
        return 0;
    }

    @Override
    boolean isNumber() {
        return false;
    }

    @Override
    boolean isZero() {
        return false;
    }

    FunDef getFunDef() {
        FunDefList funDefList = Interpreter.funDefList;

        while (!(funDefList instanceof FunDef)) {
            MultipleFunDef multipleFunDef = (MultipleFunDef) funDefList;

            if (funName.equals(multipleFunDef.funDef.header.funName)) {
                return multipleFunDef.funDef;
            }

            funDefList = multipleFunDef.funDefList;
        }

        FunDef funDef = (FunDef) funDefList;

        if (funName.equals(funDef.header.funName)) {
            return funDef;
        }

        return null;
    }

}
