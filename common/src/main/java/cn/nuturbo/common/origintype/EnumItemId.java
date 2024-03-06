package cn.nuturbo.common.origintype;

public class EnumItemId extends Identity{
    @Override
    protected void checkFormat(String id) throws IdentityFormattedException {
        if (id == null || id.isEmpty()) {
            throw new IdentityFormattedException("EnumItemId cannot be empty");
        }
    }
}
