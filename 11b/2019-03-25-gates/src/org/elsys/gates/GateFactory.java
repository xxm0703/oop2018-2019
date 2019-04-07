package org.elsys.gates;

public abstract class GateFactory {
    public static CompositeGate getXor(Wire input1,
                                       Wire input2,
                                       Wire output){
        CompositeGate gate = new CompositeGate();
        gate.addInput(input1);
        gate.addInput(input2);
        gate.addOutput(output);

        Wire a = new Wire();
        Wire b = new Wire();
        Wire c = new Wire();

        OrGate orGate
                = new OrGate(input1, input2, a);
        AndGate andGate1
                = new AndGate(input1, input2, b);
        InverterGate invertGate
                = new InverterGate(b, c);
        AndGate andGate2
                = new AndGate(a, c, output);

        gate.addGate(orGate);
        gate.addGate(andGate1);
        gate.addGate(invertGate);
        gate.addGate(andGate2);





        return gate;
    }
}
