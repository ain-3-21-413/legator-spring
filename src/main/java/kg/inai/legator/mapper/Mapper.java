package kg.inai.legator.mapper;

public interface Mapper<E, M> {

	M toModel(E entity);

	E toEntity(M model);
}
