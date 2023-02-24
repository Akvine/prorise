package ru.akvine.prorise.tech;

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.inputs.InputType;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.evaluation.classification.Evaluation;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class NeuralNetwork {

    private final static int SEED = 123;
    private final static int BATCH_SIZE = 64;
    private final static int NUM_CLASSES = 20;
    private final static int INPUT_SIZE = 1000;
    private final static int NUM_EPOCHS = 15;

    @PostConstruct
    public void init() {
//        // Загрузка и подготовка данных
//        DataSetIterator trainIterator = new HHRecordReaderDataSetIterator(BATCH_SIZE, true);
//        DataSetIterator testIterator = new HHRecordReaderDataSetIterator(BATCH_SIZE, false);
//
//        // Определение модели
//        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
//                .seed(SEED)
//                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
//                .updater(new Adam())
//                .l2(1e-4)
//                .list()
//                .layer(new DenseLayer.Builder()
//                        .nIn(INPUT_SIZE)
//                        .nOut(500)
//                        .activation(Activation.RELU)
//                        .weightInit(WeightInit.XAVIER)
//                        .build())
//                .layer(new DenseLayer.Builder()
//                        .nIn(500)
//                        .nOut(100)
//                        .activation(Activation.RELU)
//                        .weightInit(WeightInit.XAVIER)
//                        .build())
//                .layer(new DenseLayer.Builder()
//                        .nIn(100)
//                        .nOut(50)
//                        .activation(Activation.RELU)
//                        .weightInit(WeightInit.XAVIER)
//                        .build())
//                .layer(new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
//                        .nIn(50)
//                        .nOut(NUM_CLASSES)
//                        .activation(Activation.SOFTMAX)
//                        .weightInit(WeightInit.XAVIER)
//                        .build())
//                .backprop(true).pretrain(false)
//                .setInputType(InputType.convolutionalFlat(INPUT_SIZE, 1, 1))
//                .build();
//
//        MultiLayerNetwork net = new MultiLayerNetwork(conf);
//        net.init();
//        net.setListeners(new ScoreIterationListener(10));
//
//        // Обучение модели
//        fit(net, trainIterator, testIterator);
    }

    private void loadData() {

    }

    private void fit(MultiLayerNetwork net,
                     DataSetIterator trainIterator,
                     DataSetIterator testIterator) {
        for (int i = 0; i < NUM_EPOCHS; i++) {
            net.fit(trainIterator);
            Evaluation evaluation = net.evaluate(testIterator);
            System.out.println("Epoch " + i + " - Accuracy: " + evaluation.accuracy());
            trainIterator.reset();
            testIterator.reset();
        }
    }
}
