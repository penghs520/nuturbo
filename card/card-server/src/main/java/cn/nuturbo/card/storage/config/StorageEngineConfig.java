package cn.nuturbo.card.storage.config;

import cn.nuturbo.card.storage.RelationMutator;
import cn.nuturbo.card.storage.VertexMutator;
import cn.nuturbo.card.storage.impl.RelationMutatorUseMemgraph;
import cn.nuturbo.card.storage.impl.VertexMutatorUseMemgraph;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * Created by penghs at 2024/2/13 21:36
 */
@Configuration
public class StorageEngineConfig {

    @Value("${storage.engine:Memgraph}")
    private StorageEngineType storageEngineType;

    @Bean
    public RelationMutator relationRepository() {
        if (Objects.requireNonNull(storageEngineType) == StorageEngineType.Memgraph) {
            return new RelationMutatorUseMemgraph();
        }
        throw new IllegalStateException(String.format("StorageEngineType:%s is not supported yet", storageEngineType.name()));
    }

    @Bean
    public VertexMutator vertexRepository() {
        if (Objects.requireNonNull(storageEngineType) == StorageEngineType.Memgraph) {
            return new VertexMutatorUseMemgraph();
        }
        throw new IllegalStateException(String.format("StorageEngineType:%s is not supported yet", storageEngineType.name()));
    }

}
